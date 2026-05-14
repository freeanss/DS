# DS

### For all other assignment:
javac filename.java

java filename



### For assignment 3:
#### INSTALL OPENMPI

sudo apt update

sudo apt install openmpi-bin openmpi-common libopenmpi-dev


#### COMPILE

mpicc sum.c


#### RUN

mpirun -np 4 ./a.out
