public class MatrixDiagonalSum {
        public int diagonalSum(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int diagonalSum = 0;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(rows % 2 != 0){
                        if((i == (rows - cols + j)) && (i == j)){
                            diagonalSum += mat[i][j];
                        }else if((i == (rows - cols)) && (j == (cols - 1))){
                            diagonalSum += mat[i][j];
                        }else if((i == (rows - 1)) && (j == (rows - cols))){
                            diagonalSum += mat[i][j];
                        }
                    }else{
                        if((i == (rows - cols + j)) && (i == j)){
                            diagonalSum += mat[i][j];
                            if(j < cols / 2 && j > 0){
                                diagonalSum += mat[i][j + 1];
                            }if((j == cols - 2) && (i == rows - 2)){
                                diagonalSum += mat[i][j - 1];
                            }
                        }else if((i == (rows - cols)) && (j == (cols - 1))){
                            diagonalSum += mat[i][j];
                        }else if((i == (rows - 1)) && (j == (cols - rows))){
                            diagonalSum += mat[i][j];
                        }
                    }
                }
            }
            return diagonalSum;
        }
    }

/*
(rows - cols + j) (rows - cols + j) (rows - cols + j)
(0,0)             (1,1)             (2,2)

(rows - cols, cols - 1 )          (cols - 1, rows - cols)
(0,2)                    (1,1)    (2,0)


(rows - cols)

[[1,1,1,1],
[1,1,1,1],
[1,1,1,1],
[1,1,1,1]]
cols - j == 1

*/
