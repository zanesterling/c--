jc = javac

all: bin
	$(jc) *.java -d bin/

bin:
	mkdir bin

run:
	java -cp bin/ Main

clean:
	rm -rf bin/
