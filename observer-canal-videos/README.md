# Canal de Vídeos - Padrão Observer

Este projeto simula um canal de vídeos no console, em Java. Quando o canal publica um vídeo, todos os inscritos recebem um aviso, cada um pelo meio que escolheu: app, e-mail ou SMS.

No `Main`, criamos o canal "Tecnologia na Prática" com três inscritos, publicamos um vídeo, removemos o inscrito por e-mail e publicamos outro, para mostrar que ele deixa de receber.

## Como executar

Precisa do JDK 8 ou superior.

```bash
cd src
javac -encoding UTF-8 -d ../out *.java
java -cp ../out Main
```

Saída esperada:

```
[Tecnologia na Prática] Novo vídeo publicado: Introdução a Padrões de Projeto em Java
Notificação (App) para Lucas: Tecnologia na Prática postou "Introdução a Padrões de Projeto em Java"
Notificação (E-mail) para mariana.silva@gmail.com: Tecnologia na Prática postou "Introdução a Padrões de Projeto em Java"
Notificação (SMS) para (83) 98842-1904: Tecnologia na Prática postou "Introdução a Padrões de Projeto em Java"

[Tecnologia na Prática] Novo vídeo publicado: Entendendo Arquitetura Limpa
Notificação (App) para Lucas: Tecnologia na Prática postou "Entendendo Arquitetura Limpa"
Notificação (SMS) para (83) 98842-1904: Tecnologia na Prática postou "Entendendo Arquitetura Limpa"
```

## Classes

- `Subject`: interface com `adicionar`, `remover` e `notificar`.
- `Observer`: interface com o método `update`.
- `Canal`: guarda a lista de inscritos e o último vídeo. Ao publicar, chama `notificar()`.
- `InscritoApp`, `InscritoEmail` e `InscritoSMS`: implementam `Observer`, cada um com sua mensagem.
- `Main`: monta o canal e roda a demonstração.

## Por que escolhemos o Observer

O problema do projeto é que, quando o canal muda (um vídeo novo), vários objetos precisam ser avisados, e quem recebe pode mudar a qualquer momento. O Observer resolve isso porque o `Canal` só conhece a interface `Observer`. Ele não sabe se o inscrito é de app, e-mail ou SMS, e quem se inscreve ou sai não exige nenhuma alteração nele.

Sem o padrão, o `Canal` teria que chamar cada tipo de inscrito direto, com um `if` para cada um, e precisaria ser modificado toda vez que surgisse um meio novo de notificação.

## Outros padrões possíveis

O Mediator também funcionaria, com um objeto central cuidando da comunicação entre canal e inscritos, mas seria mais complexo do que o necessário para uma relação de um para muitos. O Publisher/Subscriber desacopla ainda mais, usando um intermediário de mensagens, mas faz mais sentido em sistemas distribuídos. O Strategy ajudaria a trocar a forma de notificar, mas não resolve a lista de inscritos nem o aviso automático quando algo muda.

## SOLID

- Responsabilidade Única: o `Canal` cuida dos vídeos e da lista de inscritos, e cada inscrito só cuida da própria notificação.
- Aberto/Fechado: adicionamos o `InscritoSMS` sem mexer no `Canal`.
- Substituição de Liskov: o `Canal` chama `update()` em qualquer `Observer` sem se importar com qual classe é.
- Segregação de Interfaces: `Observer` tem só o método `update`, então ninguém implementa o que não usa.
- Inversão de Dependência: o `Canal` depende da interface `Observer` e não das classes `InscritoApp`, `InscritoEmail` e `InscritoSMS`.

## Equipe

Carla Mylena, Diego Dantas e Keven