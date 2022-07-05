package class_diagram1;

public class Square extends Shape {
	private float _height;
	private float _width;

	public float getHeight() {
		return this._height;
	}

	public void setHeight(float aHeight) {
		this._height = aHeight;
	}

	public float getWidth() {
		return this._width;
	}

	public void setWidth(float aWidth) {
		this._width = aWidth;
	}

	public void draw(float aCircum) {
		throw new UnsupportedOperationException();
	}
}