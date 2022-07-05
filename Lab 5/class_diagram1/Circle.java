package class_diagram1;

public class Circle extends Shape {
	private float _size;

	public void draw(float aCircum) {
		throw new UnsupportedOperationException();
	}

	public float getSize() {
		return this._size;
	}

	public void setSize(float aSize) {
		this._size = aSize;
	}
}