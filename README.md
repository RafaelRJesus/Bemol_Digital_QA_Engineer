<summary><strong>Desafio Bemol_Digital_QA_Engineer</strong></summary><br />


<summary><strong>O projeto foi organizado em três ramificações principais:</strong></summary><br />

1. Branch Principal (main):
    - Primeiro desafio com cenários de teste descritos no README.
    - Detalhes adicionais disponíveis em um arquivo Excel "Cenarios_de_Teste.xlsx".
    - Foco da Etapa I: Fundamentos de Testes.
2. Branch de Automação Frontend (Automacao_Front):
    - Cenários de teste automatizados.
    - Cobertura da Etapa II: Automação de Teste Web I e Etapa III: Automação de Teste Web II.
3. Branch de Automação Backend (Automacao_Back):
    - Cenários de teste automatizados para API.
    - Abordagem da Etapa IV: Automação de Teste de API.

<summary><strong>Tecnologias Utilizadas no Projeto</strong></summary><br />

- Java
- Rest-Assured
- Selenium
- Gradle


<summary><strong>Ferramentas Utilizadas no Projeto</strong></summary><br />
- IntelliJ IDEA
- Git
- GitHub

# Cenários de teste 

<details>
  <summary><strong>VALIDAÇÃO 1: Acessar App</strong></summary><br />
1. CT01-Verificar se o aplicativo instala corretamente no dispositivo Android.	

- ETAPAS PARA EXECUTAR.
    - Baixar o APK, instalá-lo e abrir.	

- RESULTADOS ESPERADOS.
    - O aplicativo é instalado e pode ser aberto sem erros.
    
2. CT02-Verificar se todas as páginas do aplicativo carregam corretamente após o lançamento.	

- ETAPAS PARA EXECUTAR.
    - Abra o aplicativo e navegue por todas as telas disponíveis.	

- RESULTADOS ESPERADOS.
    - Todas as páginas devem carregar sem erros e exibir conteúdo conforme esperado

3. CT03-Verificar se o aplicativo funciona corretamente quando o usuário recebe uma chamada enquanto está usando o aplicativo.

- ETAPAS PARA EXECUTAR.
    - Simular uma chamada durante o uso do aplicativo.	
    
- RESULTADOS ESPERADOS.
    - O aplicativo deve continuar funcionando corretamente, mantendo o estado do usuário
    
4. CT04-Verificar que o aplicativo não consuma memória excessiva ou interfira com outros aplicativos.	

- ETAPAS PARA EXECUTAR.
    - Monitorar o uso de memória do aplicativo durante várias sessões de uso.
    
- RESULTADOS ESPERADOS.
    - O aplicativo deve usar memória de forma eficiente e não afetar negativamente outros aplicativos</details>
    
    
<details>
  <summary><strong>VALIDAÇÃO 2: Marvelopédia Tela cadastro de usuário</strong></summary><br />
1. CT01-Verificar se a aplicação permite o login com credenciais válidas.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de login. 
    - Insira um email válido e uma senha correta. Clique no botão de login.
    
- RESULTADOS ESPERADOS.
    - A aplicação deve permitir o login e redirecionar o usuário para a próxima tela.	

2. CT02-Verificar o comportamento da aplicação quando o campo de email é deixado vazio.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de login.
    - Insira uma senha no campo de senha.
    - Clique no botão de login sem inserir nenhuma email.
    
- RESULTADOS ESPERADOS.
    -  A aplicação deve impedir o login e exibir uma mensagem de erro indicando que o campo de email não pode estar vazio.
	

3. CT03-Verificar o comportamento da aplicação quando o campo de senha é deixado vazio.


- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de login.
    - Insira um email válido no campo de email.
    - Clique no botão de login sem inserir nenhuma senha.
    
- RESULTADOS ESPERADOS.
    - A aplicação deve impedir o login e exibir uma mensagem de erro indicando que o campo de senha não pode estar vazio.

4. CT04-Verificar o comportamento da aplicação quando são inseridas credenciais inválidas.


- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de login.
    - Insira um email inválido e uma senha incorreta.
    - Clique no botão de login.
    
- RESULTADOS ESPERADOS.
    - A aplicação deve impedir o login e exibir uma mensagem de erro indicando que as credenciais estão incorretas.


5. CT05-Verificar se o botão "Criar uma Conta" direciona corretamente os usuários para a tela de registro.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de login.
    - Toque no botão "Criar uma Conta"
    
- RESULTADOS ESPERADOS.
    - O usuário é levado para a tela de registro onde pode se inscrever para uma nova conta.</details>
 
 
<details>
  <summary><strong>VALIDAÇÃO 3: Marvelopédia Tela cadastro de usuario</strong></summary><br />
1. CT01-Verificar se o usuário consegue cadastrar uma nova senha corretamente.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de cadastro.
    - Inserir um email válido no campo de email.
    - Digitar uma senha forte e repetir a senha corretamente no campo "Repita Senha".
    - Clicar no botão "Cadastrar".
    
- RESULTADOS ESPERADOS.
    - A senha é cadastrada com sucesso e o usuário é redirecionado para a tela principal ou uma mensagem de confirmação é exibida.

2. CT02-Verificar o comportamento do aplicativo quando o campo de email está vazio.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de cadastro.
    - Deixar o campo de email vazio.
    - Digitar uma senha válida e repetir a senha corretamente.
    - Clicar no botão "Cadastrar".
    
- RESULTADOS ESPERADOS.
    - O aplicativo não permite o cadastro e exibe uma mensagem de erro solicitando que o campo de email seja preenchido.

3. CT03-Verificar se o aplicativo impede o cadastro quando as senhas digitadas não coincidem.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de cadastro.
    - Inserir um email válido.
    - Digitar uma senha válida no campo de senha.
    - Digitar uma senha diferente no campo "Repita Senha".
    - Clicar no botão "Cadastrar".
    
- RESULTADOS ESPERADOS.
    - O aplicativo exibe uma mensagem de erro informando que as senhas não coincidem.

4. CT04-Verificar o comportamento do aplicativo quando a senha digitada não atende aos requisitos de segurança.

- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de cadastro.
    - Inserir um email válido.
    - Digitar uma senha fraca no campo de senha (por exemplo, "1234").
    - Repetir a senha fraca.
    - Clicar no botão "Cadastrar".
    
- RESULTADOS ESPERADOS.
    - O aplicativo exibe uma mensagem de erro informando que a senha é muito fraca e não atende aos requisitos de segurança.

5. CT05-Verificar se o botão "Voltar" retorna corretamente para a tela anterior.


- ETAPAS PARA EXECUTAR.
    - Com o aplicativo aberto na tela de cadastro.
    - Clicar no botão "Voltar".
    
- RESULTADOS ESPERADOS.
    - O usuário é levado de volta para a tela anterior, geralmente a tela de login ou a tela inicial do aplicativo.</details>


