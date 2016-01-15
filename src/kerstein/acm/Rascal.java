package kerstein.acm;

public class Rascal {

	public static void main(String[] args) {
		int value = getValue(4, 2);
		System.out.println(value);
	}

	public static int getValue(int row, int column) {

		if (row == 0 || column == 0 || row == column) {
			return 1;
		}

		return (getValue(row - 1, column - 1) * getValue(row - 1, column) + 1)
				/ getValue(row - 2, column - 1);

	}

}
