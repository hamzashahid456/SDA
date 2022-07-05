package class_diagram2;

import java.util.Vector;
import class_diagram2.Mobile;

public class Person {
	private String _name;
	private List<Mobile> _numbers;
	public Vector<Mobile> _unnamed_Mobile_ = new Vector<Mobile>();

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public List<Mobile> getNumbers() {
		throw new UnsupportedOperationException();
	}

	public void setNumbers(List<Mobile> aNumbers) {
		throw new UnsupportedOperationException();
	}
}