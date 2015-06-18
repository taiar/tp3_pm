clean:
	rm -rf ./src/ ./data/ *.class  ./equipes/*.class ./Gui/*.class ./partidas/*.class ./tabela/*.class ./competicoes/*.class ./Database/*.class ./esportes/*.class ./pessoas/*.class

main:
	javac -sourcepath . -cp vendor/forms_rt-6.0.5.jar main.java

run: main
	java -cp vendor/forms_rt-6.0.5.jar:. main