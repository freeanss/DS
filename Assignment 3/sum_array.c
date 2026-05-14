#include <stdio.h>
#include <mpi.h>

int main(int argc, char *argv[]) {
    int rank, size;
    int num[20];

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Initialize array (1 to 20)
    for (int i = 0; i < 20; i++)
        num[i] = i + 1;

    int local_sum = 0;

    // Each process handles 5 elements (20/4 = 5)
    for (int i = rank * 5; i < (rank + 1) * 5; i++) {
        local_sum += num[i];
    }

    printf("Local sum at process %d = %d\n", rank, local_sum);

    MPI_Finalize();
    return 0;
}
