package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    public List<Advertisement> getAvailableAdvertisement() {
        List<Advertisement> activeAdvertisements = new ArrayList<>();
        for (Advertisement advert : advertisementStorage.list()) {
            if (advert.isActive()) {
                activeAdvertisements.add(advert);
            }
        }
        return activeAdvertisements;
    }

    public List<Advertisement> getNoAvailableAdvertisement() {
        List<Advertisement> noActiveAdvertisements = new ArrayList<>();
        for (Advertisement advert : advertisementStorage.list()) {
            if (!advert.isActive()) {
                noActiveAdvertisements.add(advert);
            }
        }
        return noActiveAdvertisements;
    }
}
