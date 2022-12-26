
main.o: main.cpp main.hpp

	g++ -g tabuleiro.h tabuleiro.c struct.hpp main.hpp utils.cpp utility.cpp minimax.cpp main.cpp -o testeraposa -l hiredis

controlador: controlador.c

clean:

	rm *.o testeraposa
