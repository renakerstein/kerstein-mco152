package kerstein.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	private HashMap<Package, Location> map1 = new HashMap<Package, Location>();
	private HashMap<Location, Set<Package>> map2 = new HashMap<Location, Set<Package>>();

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		map1.put(pkg, location);
		Set<Package> packages = map2.get(location);
		// if it hasn't been initialized yet:
		if (packages == null) {
			packages = new HashSet<Package>();
		}
		packages.add(pkg);
		map2.put(location, packages);

	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		if (map1.containsKey(pkg)) {
			map1.put(pkg, location);
			Set<Package> packages = map2.get(location);
			if (packages == null) {
				packages = new HashSet<Package>();
			}
			packages.add(pkg);
			map2.put(location, packages);

		}
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.look at java docs
	 */
	public Set<Package> getPackages(Location location) {
		if (map1.containsValue(location)) {
			return map2.get(location);

		}
		return null;
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		if (map1.containsKey(pkg)) {
			return map1.get(pkg);
		}
		return null;
	}

}
