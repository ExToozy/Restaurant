package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getProfitMap() {
        Map<String, Long> res = new HashMap();
        List<EventDataRow> rows = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0l;
        for (EventDataRow row : rows) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, 0l);
            }
            total += dataRow.getAmount();
            res.put(date, res.get(date) + dataRow.getAmount());
        }

        res.put("Total", total);

        return res;
    }

    public Map<String, Map<String, Integer>> getCookWorkloadingMap() {
        Map<String, Map<String, Integer>> res = new HashMap(); //name, time
        List<EventDataRow> rows = statisticStorage.get(EventType.COOKED_ORDER);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow row : rows) {
            CookedOrderEventDataRow dataRow = (CookedOrderEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, new HashMap<>());
            }
            Map<String, Integer> cookMap = res.get(date);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName)) {
                cookMap.put(cookName, 0);
            }

            Integer totalTime = cookMap.get(cookName);
            cookMap.put(cookName, totalTime + dataRow.getTime());
        }

        return res;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private List<EventDataRow> get(EventType eventType) {
            return storage.get(eventType);
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
