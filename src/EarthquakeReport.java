import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.EarthquakeUSGS;

import java.util.List;

// This program fragment illustrates how to access the USGS earthquake data
public class EarthquakeReport {
    public static void main(String[] args) throws Exception {

        // create Bridges object
        Bridges bridges = new Bridges (1, "YOUR USERNAME ", "YOUR API KEY");
        // read the earth quake  data and build the BST
        bridges.setTitle("Accessing USGIS Earthquake Data (USGS Data)");

        DataSource ds = bridges.getDataSource();
        //Create elements and insert them into the tree
        BinarySearchTree<EarthQuake> tree = new BinarySearchTree<>();

        // get 100 most recent earthquake records
        List<EarthquakeUSGS> eq_list = ds.getEarthquakeUSGSData(100);

        // add the earthquakes to a binary search tree
        for (EarthquakeUSGS quake: eq_list) {
            tree.add(new EarthQuake(quake));
        }

        System.out.println("Greatest magnitude earthquake: " + tree.getLargest());
        System.out.println("Least magnitude earthquake: " + tree.getSmallest());

        System.out.println("All recnt earthquakes:");
        java.util.Iterator<EarthQuake> quakesList = tree.iterator();

        while (quakesList.hasNext()) {
            System.out.println(quakesList.next());
        }

        // visualize the tree
        bridges.setDataStructure(tree.getRoot());

        bridges.visualize();
    }
}
