#language: pt
Funcionalidade: Calculadora

        Cenario: Soma de dois numeros
            Dado que eu somo dois valores <numx> e <numy>
            Quando eu clicar em igual
            Entao o <valorEsperado> deve ser exibido corretamente

       Exemplos:
       
       numx |  numy  | valorEsperado
        5   |    9   |     14
        8   |    3   |     11
        2   |    7   |      9

