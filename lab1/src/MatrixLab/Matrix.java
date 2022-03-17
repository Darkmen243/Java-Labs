
package MatrixLab;
public class Matrix {
    private final int cols, rows;
    private final double[][] matrix;

    public Matrix(int matrixRows, int matrixCols) throws NegativeArraySizeException {
        if (matrixCols <= 0 || matrixRows <= 0) {
            throw new NegativeArraySizeException("Negative matrix size");
        }

        cols = matrixCols;
        rows = matrixRows;
        matrix = new double[rows][cols];
    }
    
    public Matrix(double[][] m) throws IllegalArgumentException {
        if (m == null) {
            throw new NullPointerException("Matrix cannot be null");
        }

        rows = m.length;
        cols = m[0].length;
        matrix = m;
    }
    
    public Matrix(Matrix copy) {
        matrix = new double[copy.rows][copy.cols];
        rows = copy.rows;
        cols = copy.cols;

        for (var i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, copy.matrix[i], 0, cols);
        }
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }

    public double get(int row, int column) throws IndexOutOfBoundsException {
        if (row >= rows || column >= cols) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        return matrix[row][column];
    }
    public Matrix add(Matrix another) throws UnsupportedOperationException {
        if (cols != another.cols || rows != another.rows) {
            throw new UnsupportedOperationException("Matrices should have equal sizes to sum it");
        }

        var result = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result.matrix[i][j] = matrix[i][j] + another.matrix[i][j];
            }
        }

        return result;
    }

    public Matrix sub(Matrix another) throws UnsupportedOperationException {
        if (cols != another.cols || rows != another.rows) {
            throw new UnsupportedOperationException("Matrices should have equal sizes to subtract it");
        }

        var result = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result.matrix[i][j] = matrix[i][j] - another.matrix[i][j];
            }
        }

        return result;
    }

    public Matrix mult(Matrix another) throws UnsupportedOperationException {
        if (cols != another.rows) {
            throw new UnsupportedOperationException("Wrong sized matrices in multiplication");
        }

        var result = new Matrix(cols, another.rows);

        for (var i = 0; i < result.cols; i++) {
            for (var j = 0; j < result.rows; j++) {
                double value = 0;
                for (var k = 0; k < cols; k++) {
                    value += matrix[i][k] * another.matrix[k][j];
                }
                result.matrix[i][j] = value;
            }
        }

        return result;
    }
    public Matrix mult(int multiplier) {
        var result = new Matrix(rows, cols);

        for (var i = 0; i < result.rows; i++) {
            for (var j = 0; j < result.cols; j++) {
                result.matrix[i][j] = matrix[i][j] * multiplier;
            }
        }

        return result;
    }

    public Matrix mult(double multiplier) {
        var result = new Matrix(rows, cols);

        for (var i = 0; i < result.rows; i++) {
            for (var j = 0; j < result.cols; j++) {
                result.matrix[i][j] = matrix[i][j] * multiplier;
            }
        }

        return result;
    }

    public void set(double value, int col, int row) throws IndexOutOfBoundsException {
        if (col >= cols || row >= rows) {
            throw new IndexOutOfBoundsException("Invalid set operation");
        }

        matrix[col][row] = value;
    }

    public double getDeter() {
        double result = 0;
        if (rows == 3 && cols == 3) {
            result = matrix[0][0] * matrix[1][1] * matrix[2][2] + matrix[2][0] * matrix[0][1] * matrix[1][2] +
                    matrix[0][2] * matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1] * matrix[0][2] -
                    matrix[1][0] * matrix[0][1] * matrix[2][2] - matrix[2][1] * matrix[1][2] * matrix[0][0];
            return result;
        }

        if (rows == 2 && cols == 2) {
            result = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            return result;
        }

        for (var i = 0; i < cols; i++) {
            var j = 0;
            var tmp = new Matrix(rows - 1, cols - 1);
            while (j < i) {
                var k = 1;
                while (k < rows) {
                    tmp.matrix[k - 1][j] = matrix[k][j];
                    k++;
                }
                j++;
            }

            j = i + 1;

            while (j < cols) {
                var k = 1;
                while (k < rows) {
                    tmp.matrix[k - 1][j - 1] = matrix[k][j];
                    k++;
                }
                j++;
            }

            if (i % 2 == 0) {
                result += matrix[0][i] * tmp.getDeter();
            } else {
                result -= matrix[0][i] * tmp.getDeter();
            }
        }

        return result;
    }
    public double[][] getRawMatrix() {
        var result = new double[rows][cols];

        for (var i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, result[i], 0, cols);
        }

        return result;
    }

}