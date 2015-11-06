package kerstein.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	private int rows;
	private int columns;
	private HashMap<String, Boolean> map;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		map = new HashMap<String, Boolean>();

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
	SeatOutOfBoundsException {
		boolean found = false;
		boolean f = false;
		String[] seats = seatName.split("");
		for (int i = 1; i < columns; i++) {
			char x = (char) i;
			if (seats[1].charAt(0) == x) {
				f = true;
			}
		}
		for (int i = 0; i < rows; i++) {
			for (char alphabet = 'A'; alphabet < rows; alphabet++) {
				if (seats[0].charAt(0) == alphabet) {
					found = true;
				}
			}
		}
		if (found == false && f == false) {
			throw new SeatOutOfBoundsException();
		}

		boolean filled = map.get(seatName);
		if (filled == false) {
			map.put(seatName, true);
		} else {
			throw new AlreadyReservedException();
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		boolean filled = map.get(seatName);
		if (filled == true) {
			return true;
		}
		return false;
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD \n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Boolean> entry : map.entrySet()) {
			for (int i = 0; i < columns; i++) {
				System.out.println(i + " ");
				if (entry.getValue() == true) {
					builder.append("#");
				} else {
					builder.append("o");

				}

			}
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException {
		ArrayList<String> group = new ArrayList<String>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				for (Map.Entry<String, Boolean> entry : map.entrySet()) {
					if (entry.getValue() == true) {
						throw new NotEnoughSeatsException();
					}
				}
			}
		}
		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		int count = 0;
		int size = rows * columns;
		for (String key : map.keySet()) {
			count++;
		}
		if (count <= size) {
			return false;
		} else {
			return true;
		}
	}

}
