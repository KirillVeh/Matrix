
    public class Matrix {
        private int[][] matrix;
        private int rows;
        private int cols;

        public Matrix(int[][] matrix) {
            this.matrix = matrix;
            this.rows = matrix.length;
            this.cols = matrix[0].length;
        }

        public Matrix add(Matrix other) {
            if (this.rows != other.rows || this.cols != other.cols) {
                throw new IllegalArgumentException("Matrices must have the same dimensions");
            }

            int[][] result = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = this.matrix[i][j] + other.matrix[i][j];
                }
            }

            return new Matrix(result);
        }

        public Matrix subtract(Matrix other) {
            if (this.rows != other.rows || this.cols != other.cols) {
                throw new IllegalArgumentException("Matrices must have the same dimensions");
            }

            int[][] result = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = this.matrix[i][j] - other.matrix[i][j];
                }
            }

            return new Matrix(result);
        }

        public Matrix multiply(Matrix other) {
            if (this.cols != other.rows) {
                throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
            }

            int[][] result = new int[this.rows][other.cols];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    for (int k = 0; k < this.cols; k++) {
                        result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                    }
                }
            }

            return new Matrix(result);
        }

        public void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

