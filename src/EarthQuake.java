/**
 * An object reporesentation of an EarthQuake from USGS API Feed
 */

import bridges.data_src_dependent.EarthquakeUSGS;

public class EarthQuake implements Comparable<EarthQuake> {
    private EarthquakeUSGS earthquake;

    public EarthQuake(EarthquakeUSGS earthquake) {
        this.earthquake = earthquake;
    }

    @Override
    public int compareTo(EarthQuake other) {
        double result = this.earthquake.getMagnitude() - other.earthquake.getMagnitude();

        if (result < 0) {
            return -1;
        }
        else if (result > 0) {
            return +1;
        }
        else {
            return 0;
        }
    }

    public String toString() {
        return earthquake.getMagnitude() + " " + earthquake.getLocation() + " " + earthquake.getTime();
    }
}
