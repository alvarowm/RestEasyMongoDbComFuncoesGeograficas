	Este projeto é um servidor REST feito em Java que utiliza Maven, RestEasy e MongoDb.
	O servidor NoSql MongoDB foi usado para possibilitar as consultas espaciais acessando assim os PDVS mais próximos e que possuam áreas atendidas.
	A ferramenta foi escolhida já que os dados disponibilizados já estavam em JSON e ela possue nativamente funções que possibilitam trabalhar com coordenadas.
	Para tal, após a inserção da "collection", é necessário criar dois índices que possibilitam o uso das funções geográficas, seguem o guia da configuração do MongoDB:
	
	//Para criar a Collection
	db.createCollection("pdvs")
	//Inserir os registros
	db.pdvs.insert(JSON);
	
	Onde JSON é o JSON disponibilizado.
	 
	db.pdvs.createIndex({ "address": "2dsphere" })
	db.pdvs.createIndex({ "coverageArea": "2dsphere" })
	
	*Encontrei 3 problemas nos registros disponibilizados com os seguintes Ids:
	6;
	8;
	e 17.
	
	Acredito que exista algum problema na forma tação do MultiPolygon.
	
	Junto com o projeto está o "insert" já ajustado.
	
	Para o deploy basta importar o projeto maven no eclipse e configurar o MongoDB com usuário e senha encontrados no MongoDBClient.
	Para criar um usuário:
	
	db.createUser(
	{ user: 'alvaro', 
		pwd: 'nH8019*MP0ud', 
		roles: 
			[ { role: "userAdminAnyDatabase", db: "admin"}] 
	}
	);
	
	Como ferramentas adicionais utilizei Docker para criar um conteinar com o MongoDb e Studio 3T para trabalhar com o NoSql.
	
	Caso queira utilizar o Docker seguem os comandos para criação do container:
	
	//Para baixar a imagem do MongoDB
	docker pull mongo
	
	//Para listar os containers e pegar o id correto
	docker ps -a
	
	//Para iniciar o serviço e ajustar as portas necessárias
	docker run -d -p 27017:27017 -p 28017:28017 -e MONGODB_PASS="nH8019*MP0ud" mongo

	//Para inicializar 
	docker start id	
	
	Foi disponibilizado juntamente com o fonte um war para o deploy sem precisar configurar o ambiente de desenvolvimento.
	
	