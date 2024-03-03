package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage INSTANCE = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();


    private AdvertisementStorage() {
        Object videoContent = new Object();
        Advertisement[] ads = {
                new Advertisement(videoContent, "Video 01",
                        5000, 100, 3 * 60),
                new Advertisement(videoContent, "Video 02",
                        100, 10, 15 * 60),
                new Advertisement(videoContent, "Video 03",
                        400, 2, 10 * 60),
                new Advertisement(videoContent, "Video 04",
                        5000, 100, 60 * 87),
                new Advertisement(videoContent, "Video 05",
                        500, 100, 60 * 12),
                new Advertisement(videoContent, "Video 06",
                        250, 50, 60 * 2),
                new Advertisement(videoContent, "Video 07",
                        250, 50, 60 * 3),
                new Advertisement(videoContent, "Video 08",
                        250, 50, 60 * 5),
                new Advertisement(videoContent, "Video 09",
                        250, 50, 60 * 2),
                new Advertisement(videoContent, "Video 10",
                        250, 50, 60 * 10),
        };
        videos.addAll(Arrays.asList(ads));
    }

    public static AdvertisementStorage getInstance() {
        return INSTANCE;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
