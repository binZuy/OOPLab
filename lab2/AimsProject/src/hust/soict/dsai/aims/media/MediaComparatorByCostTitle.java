package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        int costComparison = Double.compare(media2.getCost(), media1.getCost());
        if (costComparison == 0) {
            // If costs are the same, sort alphabetically by title
            return media1.getTitle().compareTo(media2.getTitle());
        }
        return costComparison;
    }
}
