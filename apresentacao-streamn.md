# Trabalhando com a API Stream

### O que é um Stream?
Segundo o javadoc da interface stream, uma stream é uma seqüência de elementos que suportam agregação seqüencial e paralelo.

Pesquisando em livros e artigo, o conceito padrão é que stream é uma interface que padroniza o fluxo de transmissão e o tratamento de dados. A partir dela, é possível processar dados de forma declarativa. Não importa como os fluxos de transmissão ou tratamento trabalhem internamente, todos eles apresentam o mesmo modelo simples para programas que os usam: um fluxo é uma seqüência de dados.

Identifica-se então que a ideia é dar um comportamento padrão para a execução de diferentes tarefas, de modo que ordenação, filtro, transformação tenham um mesmo padrão e se utilizem de interface fluente.

### Uso de streams na API de coleções
Ao possibilitar a transformar de coleções em streams, deu-se as coleções, uma forma de se trabalhar as informações da coleção aplicando diferentes tratamentos através de interfaces fluentes.

### Um passo atrás... o que é uma lambda?
Em resumo, pode-se dizer que uma lambda é o modo mais simples de se implementar uma interface que possui um único método a ser implementado.
Obs.: uma interface que possui um só método a ser implementado, é chamada de interface funcional.

##### Antes e depois da lambda, um exemplo:
>// Como era iterar a lista no Java 7 
for (Cliente cliente: clientes) {
	System.out.println("Nome: "+cliente.getNome()+" - Pontos: "+cliente.getPontos());
}

>// Como é iterar a lista com lambda 
clientes.forEach(cliente -> System.out.println(cliente.getNome()+" - Pontos: "+cliente.getPontos()));

O forEach está imprimindo o nome e a quantidade de pontos do cliente, mas de onde vem isso? Qual argumento o forEach recebe?
Ele recebe um java.util.function.Consumer , que tem um único método, o accept. 

**Mas... O QUE O MÉTODO ACCEPT FAZ???**
Ele faz o que você definir, as únicas regras são: ele recebe alguma coisa e não retorna nada.
Então no exemplo, o accept vai receber o cliente e imprimir o nome e a quantidade de pontos dele porque a implementação do accept é nossa lambda!
Quando executo um for sobre uma lista a cada iteração recebo um item dessa lista, na lambda, este item é o objeto que é passado para o script de execução. O script pode fazer qualquer coisa, neste caso, imprimir o nome e a quantidade de pontos do item cliente, da lista de clientes.


### Dois passos a frente... trabalhando com stream
Como já citado, a API de stream serve para trasmitir e tratar dados, sendo que o tratamento pode ser aplicar filtros, retornar atributos de um objeto da lista, criar sub-listas, ordenar o conteúdo já tratado, entre outras situações. É importante salientar que a lista original NÃO É alterada ao ser utilizado stream.

#### Criando filtros em coleções
Pode-se aplicar filtros em coleções, utilizando a API de streams. Para isso, transforma-se a coleção em stream e em seguida aplica-se o método filter da API stream. 
Exemplo:

> List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();
>
 tabelaBrasileiraoA.stream()
 		.filter(registro -> registro.getPontos() >= 57)
		
Mas como o que o filter recebe?
Na lambda, recebe-se registro por registro da coleção (logo a posição da coleção, tranforma-se num objeto do tipo da coleção) e a lambda deve-se retornar uma expressão que tem de retornar um booleano, a qual será a aplicação do filtro. 

E o que o filter retorna?
O retorno será um stream "tipado" com o tipo da coleção contendo os registros que passaram pelo filtro.

#### Iterando sobre o stream
Tomando o exemplo acima por base, querendo-se imprimir a lista dos registros com 57 pontos ou mais, deve-se fazer o seguinte incremento no código que manipula o stream:

> tabelaBrasileiraoA.stream()
		.filter(registro -> registro.getPontos() >= 57)
		.forEach(registro -> System.out.println("Time: "+registro.getTime()+ " - Pontos: "+registro.getPontos()));

#### Criando sub-listas e alterando o valor dos objetos da lista
O filtro em uma lista nos permite criar sub-listas. Esta sub-lista pode ser iterada normalmente, permitindo assim, que os atributos de cada objeto da lista sejam manipulados.
Exemplo:

> tabelaBrasileiraoA.stream()
		.sorted(Comparator.comparingInt(Registro::getPontos).reversed()) //ordena por pontos em ordem decrescente
		.collect(Collectors.toList()) //transforma o stream novamente em lista
		.subList(0,8) //cria uma sub-lista
		.forEach(registro -> registro.setLibertadores(true)); //atribui true ao atributo "libertadores" do registro
		
Isto poderia ser feito diretamente na lista sem o uso do stream, porém com uma diferença. Sem o uso do stream, ao ordenarmos a lista estaria-se ordenando a lista original e portanto alterando uma estrutura que talvez não se queira alterar. No exemplo acima, a única coisa realmente alterada na lista, é o atributo libertadores para os oito times com maior pontuação (independente de onde eles se encontram na lista).


#### Transformando dados com MAP
Um dos métodos que a API stream oferece é o MAP. Cobinado as coleções, o map pega um elemento da coleção e permite que se possa manipular esse elemento ou seus atributos, passando para o próximo passo da execução, um tipo diferente dos itens da lista.
Exemplo:

>List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();
>
tabelaBrasileiraoA.stream()
		.map(Registro::getTime)
		.collect(Collectors.toList())
		.forEach(System.out::println);

Analisando o exemplo, tabelaBrasileiraoA é uma lista de objetos da classe Registro. Através do método map, consegue-se retornar apenas o atributo (que é do tipo String) de cada um dos elementos da lista. O método collect(Collectors.toList()), trasforma estas String em uma lista de String. Por fim, percorre-se a lista, imprimindo o seu conteúdo.
**Observação: ** o _".forEach(System.out::println)"_ é a mesma coisa que _".forEach(nomeTime -> Sistem.out.println(nomeTime))"_. Aqui é feito o uso de **method reference**. A JVM interpreta que no forEach irão passar os elementos da lista de String, logo a cada iteração ter-se-á uma string (nome do time) no loop. Como o método System.out.println recebe um único argumento, a JVM interpreta que a string que está no loop no momento deve ser passada como parâmetro para o método System.out.println.

#### Processando números com MAP e funções de agregação
Com o uso do map, pode-se pegar atributos numéricos de um objeto e processá-lo em funções de agregação tais como adição, subtração, divisão, multiplicação. 
Exemplo:

> List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();
>
Double media = tabelaBrasileiraoA.stream()
		.mapToInt(Registro::getPontos)
		.average()
		.getAsDouble();
		
No exemplo acima, tem-se a média de pontos dos times do campeonato brasileiro. Através do método mapToInt, pegou-se cada elemento da lista de registro e extraiu-se o número de pontos e cada um dos elementos. Ao invorcar o método average(), obteve-se a média destes pontos. Como o retorno é um Optional<Double>, utiliza-se o método getAsDouble() para convertê-lo num double.

Porém, a IDE nos avisa que há algo "estranho". Ocorre que por retornar um Optional&lsaquo;Double&rsaquo; o valor pode não existir, ou seja, ser nulo. Ao tentar converter algo nulo para Double ocorrerá um NullPointerException.

Para tratar esta situação, podemos fazer a seguinte alteração:
Double media = tabelaBrasileiraoA.stream()
		.mapToInt(Registro::getPontos)
		.average()
		.orElse(0);

Neste caso, se algo fizer com que a operação torne-se nula, o retorno será zero.

#### Fazendo agregação com MAP e reduce
Outra forma de fazer operações de agregação é a utilização do método reduce. Através deste método pode-se fazer agreção com números e também com String.
Exemplo:

>List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();
int valorInicial = 0;
vitorias = tabelaBrasileiraoA.stream()
		.map(Registro::getVitorias)
		.reduce(valorInicial, (a, b) -> a + b);
>
vitorias = tabelaBrasileiraoA.stream()
		.map(Registro::getVitorias)
		.reduce(valorInicial, Integer::sum);
>
String nomes = tabelaBrasileiraoA.stream()
	.map(registro -> registro.getTime()+"  ")
	.reduce(String::concat)
	.orElse("");
>
System.out.println(nomes);

Nos exemplos acima, os dois primeiros fazem exatamente a mesma coisa, apenas o tratamento no reduce é diferente, mas o sentido é o mesmo. No terceiro exemplo, faz-se a concatenação dos nomes dos times que participaram do Brasileirão 2017.

#### Utilizando o ifPresent para verificar se um Optional retornou valor
No exemplo abaixo, temos uma forma mais resumida de imprimir os nomes dos times que participaram do Brasileirão 2017. Como o método reduce retorna um Optional, faz-se o uso do método ifPresent (disponível na classe Optional) para verificar se o Optional retornou algum dado. Na lambda do ifPresent, é passado o que deve ser feito com esse dado caso ele exista. No caso do exemplo, deve-se imprimir na saída padrão.
Exemplo:
> System.out.println("----- Outra forma de imprimir os nomes ---------");
tabelaBrasileiraoA.stream()
		.map(registro -> registro.getTime()+"  ")
		.reduce(String::concat)
		.ifPresent(System.out::println);

				
#### Testando predicados
Há casos em que não é necessário filtrar os dados, mas precisa testar condições de verdadeiro ou falso, da existência ou não de um determinado dado. Pode-se fazer isso, combinando o stream com os métodos anyMatch, noneMatch e allMatch. Respectivamente, eles verificam se:

- algum registro atende a condição esperada
- nenhum registro atende a condição esperada
- todos os registros atendem a condição esperada.

Exemplo:

> System.out.println("Existe o Tubarão no brasileirão? " +
		tabelaBrasileiraoA.stream()
				.anyMatch(registro -> "Tubarão".equals(registro.getTime())));
>
System.out.println("Não existe o Tubarão no brasileirão? " +
		tabelaBrasileiraoA.stream()
				.noneMatch(registro -> "Tubarão".equals(registro.getTime())));
>
System.out.println("Todos os times ganharam aos menos uma partida no brasileirão? "+
		tabelaBrasileiraoA.stream().allMatch(registro -> registro.getVitorias() > 0));	

		
#### Tópicos que não foram abordados
Faltou ainda abordar e exemplicar o uso do FlatMap, o uso de agrupamento, particionamento e paralelismo com mapas. Recomendo a leitura do livro Java 8 Prático, nele estes assuntos são abordados de maneira extremamente didática.

#### Mão na massa!
Com base nos exemplos passados, os seguintes dados:

- Uma string contendo os nomes dos quatro times de maior pontuação, separados por " - "
- A soma dos pontos dos quatro últimos colocados
- Listar o nome dos times que tiveram 14 vitórias
- Listar o nome dos times e a sua respectiva pontual, daqueles que tiveram entre 38% a 45% de aproveitamento. Obs.: 100% de aproveitamento daria 114 pontos. 
		
### **Referências:	**
http://www.oracle.com/technetwork/pt/articles/java/processamento-streams-java-se-8-2763688-ptb.html

http://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html

https://stackoverflow.com/questions/6327904/stream-definition

http://www.matera.com/br/2015/01/23/entendendo-a-stream-api-do-java-8/

SILVEIRA, PAULO.; TURINI, RODRIGO. Java 8 Prático -  Streams e novos recursos da Linguagem. São Paulo: Casa do Código, 2017.


