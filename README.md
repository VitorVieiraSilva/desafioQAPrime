#Casos de uso em BDD

**Cenario Login sucesso**<br />
DADO que esteja na tela de login da aplicacao<br />
QUANDO informo credenciais validas<br />
E clica em Sign in<br />
ENTAO o sistema redireciona para a tela my-account<br />

**Cenario Login erro**<br />
DADO que esteja na tela de login da aplicacao<br />
QUANDO informo email valido<br />
E Informe senha incorreta<br />
E clica em Sign in<br />
ENTAO o sistema retorna mensagem de erro “invalid password”<br />

**Cenario filtro categoria**<br />
DADO que esteja na tela inicial<br />
E clico no botao Dress<br />
QUANDO seleciono a categoria Casual Dresses<br />
ENTAO o sistema aplica exibe somente itens da categoria selecionada<br />
