public class LimitingRectangle {
    int[][] points;
    int minX, maxX, minY, maxY;

    public LimitingRectangle(int[][] points) {
        this.points = points;

        minX = points[0][0];
        maxX = points[0][0];
        minY = points[0][1];
        maxY = points[0][1];

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }
    }

    public int getWidth() {
        return maxX - minX;
    }

    public int getHeight() {
        return maxY - minY;
    }

    public String getBorders() {
        String s = ", ";
        StringBuilder builder = new StringBuilder();

        builder.append(minY);
        builder.append(s);
        builder.append(maxY);
        builder.append(s);
        builder.append(minX);
        builder.append(s);
        builder.append(maxX);

        return builder.toString();
    }
}