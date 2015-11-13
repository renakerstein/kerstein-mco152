package kerstein.ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase ups = new UPSDatabase();
		Set<Package> package1 = new HashSet<Package>();
		Location loc = new Location(98765, 23456);
		Package pkg = new Package("#12345");
		package1.add(pkg);
		ups.addPackageToLocation(loc, pkg);
		Assert.assertEquals(ups.getPackages(loc), package1);
		Assert.assertEquals(ups.getLocation(pkg), loc);
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase ups = new UPSDatabase();
		Set<Package> package2 = new HashSet<Package>();
		Location loc1 = new Location(23543, 54893);
		Package pkg = new Package("#89564");
		ups.addPackageToLocation(loc1, pkg);
		package2.add(pkg);
		Location loc2 = new Location(98765, 23456);
		ups.updatePackageLocation(pkg, loc2);
		Assert.assertEquals(ups.getPackages(loc2), package2);
		Assert.assertEquals(ups.getLocation(pkg), loc2);
		Assert.assertNull(ups.getPackages(loc1));
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Location loc = new Location(45345, 76545);
		Assert.assertNull(ups.getPackages(loc));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase ups = new UPSDatabase();
		Package pkg = new Package("#54359");
		Assert.assertNull(ups.getLocation(pkg));

	}

}
