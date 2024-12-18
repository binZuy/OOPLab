package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	public int compare(Media media1, Media media2) {
		int titleComparison = media1.getTitle().compareTo(media2.getTitle());
	        if (titleComparison == 0) {
	            // If titles are the same, sort by higher cost first
	            return Double.compare(media2.getCost(), media1.getCost());
	        }
	        return titleComparison;
		}
}

