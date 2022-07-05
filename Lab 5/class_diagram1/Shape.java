package class_diagram1;

public class Shape {
	private float _radius;
	private String _color;

	public float getRadius() {
		return this._radius;
	}

	public void setRadius(float aRadius) {
		this._radius = aRadius;
	}

	public String getColor() {
		return this._color;
	}

	public void setColor(String aColor) {
		this._color = aColor;
	}

	public void draw(float aCircum) {
		throw new UnsupportedOperationException();
	}
}