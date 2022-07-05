package class_diagram2;

import java.util.Vector;
import class_diagram2.Person;

public class Mobile {
	private String _mobile_no;
	public Vector<Person> _unnamed_Person_ = new Vector<Person>();

	public String getMobile_no() {
		return this._mobile_no;
	}

	public void setMobile_no(String aMobile_no) {
		this._mobile_no = aMobile_no;
	}
}