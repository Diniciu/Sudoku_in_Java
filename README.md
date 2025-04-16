---

# Classe `Space`

A classe `Space` representa uma célula individual no tabuleiro do jogo. Cada célula pode conter um valor atual, um valor esperado e uma indicação de se é fixa ou não.

## Atributos:
- `actual`: (Integer) O valor atual da célula. Pode ser `null` se a célula estiver vazia.
- `expected`: (int) O valor esperado para a célula. Este é o valor correto que deve ser preenchido.
- `fixed`: (boolean) Indica se a célula é fixa (não pode ser alterada pelo jogador).

## Construtor:
- Valida que o valor esperado (`expected`) está dentro de um intervalo válido (1 a 9).
- Inicializa os atributos `expected` e `fixed`.
- Se a célula for fixa (`fixed == true`), o valor atual (`actual`) é automaticamente definido como o valor esperado (`expected`).

## Métodos:
- `getActual()`: Retorna o valor atual da célula.
- `setActual(Integer actual)`: Define o valor atual da célula, mas só permite a alteração se a célula não for fixa.
- `clearSpace()`: Limpa o valor atual da célula, definindo-o como `null`.
- `getExpected()`: Retorna o valor esperado da célula.
- `isFixed()`: Retorna se a célula é fixa.

---

# Enumeração `GameStatusEnum`

A enumeração `GameStatusEnum` define os possíveis estados do jogo.

## Valores:
- `NON_STARTED`: Representa o estado "não iniciado".
- `INCOMPLETE`: Representa o estado "incompleto".
- `COMPLETE`: Representa o estado "completo".

## Atributos e Métodos:
- `label`: (String) Um rótulo descritivo para o estado.
- `getLabel()`: Retorna o rótulo do estado.

Essa enumeração é usada para determinar e descrever o estado atual do jogo.

---

# Classe `Board`

A classe `Board` representa o tabuleiro do jogo e gerencia a lógica principal, como o estado do jogo, validações e alterações nos valores das células.

## Atributos:
- `NON_STARTED`, `INCOMPLETE`, `COMPLETE`: Constantes que representam os estados do jogo, baseados na enumeração `GameStatusEnum`.
- `spaces`: (List<List<Space>>) Uma matriz bidimensional de objetos `Space`, representando o tabuleiro.

## Construtor:
- Recebe uma matriz bidimensional de células (`spaces`) e a inicializa.

## Métodos:
- `getSpaces()`: Retorna a matriz de células do tabuleiro.
- `getStatus()`: Retorna o estado atual do jogo:
  - `NON_STARTED`: Se nenhum espaço não fixo tiver um valor definido.
  - `INCOMPLETE`: Se houver espaços sem valor definido.
  - `COMPLETE`: Se todos os espaços estiverem preenchidos corretamente.
- `hasErrors()`: Verifica se há erros no tabuleiro, comparando os valores atuais com os valores esperados.
- `changeValue(int col, int row, int value)`: Altera o valor de uma célula específica, se ela não for fixa e o valor for válido.
- `clearValue(int col, int row)`: Limpa o valor de uma célula específica, se ela não for fixa.
- `reset()`: Limpa todos os valores do tabuleiro, exceto os valores das células fixas.
- `gameIsFinished()`: Verifica se o jogo está finalizado, ou seja, se não há erros e o estado é `COMPLETE`.

---

# Resumo Geral

- A classe `Space` gerencia as células individuais do tabuleiro.
- A enumeração `GameStatusEnum` define os estados possíveis do jogo.
- A classe `Board` gerencia o tabuleiro como um todo, incluindo a lógica de validação, alteração de valores e verificação do estado do jogo.
