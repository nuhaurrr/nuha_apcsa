package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);

    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        double peri = 0.0;
        Point2D.Double prev = myPolygon.get(0);
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i+1) % myPolygon.size());
            peri += p1.distance(p2);
        }
        return peri;
       
    }

    public double area() {
        // TODO: Calculate the area.
       double area = 0.0;
        int points = myPolygon.size();
        if (points < 2) {
            return 0;
        }
        for (int i = 0; i < points; i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i+1) % points);
            area += (p1.x * p2.y - p2.x * p1.y);
        }
        return Math.abs(area / 2.0);
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}

//got project 