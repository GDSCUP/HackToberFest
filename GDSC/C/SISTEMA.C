#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct disciplina{
	char nome[20];
	float media, notas[3];
};

struct cadastro{
	char nome[20], departamento[20], curso[20];
	int senha, codigo;
	struct disciplina disc[5];
	struct {
		int dia, mes, ano;
	}birthday;

	struct {
		char distrito[10], bairo[10];
		int quarteirao, casanr;
	}endereco;
};


void cadastrarDocente (struct cadastro dados[], int quantDocentes){
			
	printf("Digite o seu nome: ");
	scanf("%s",&dados[quantDocentes].nome);
	printf("Digite o seu codigo: ");
	scanf("%d",&dados[quantDocentes].codigo);
	printf("=====Data de Nascimento======\n");
	printf("Dia: ");
	scanf("%d",&dados[quantDocentes].birthday.dia);
	printf("Mes: ");
	scanf("%d", &dados[quantDocentes].birthday.mes);
	printf("Ano: ");
	scanf("%d", &dados[quantDocentes].birthday.ano);
	printf("=====Endereco======\n");
	printf("Distrito/Municipio: ");
	scanf("%s", &dados[quantDocentes].endereco.distrito);
	printf("Bairo: ");
	scanf("%s",&dados[quantDocentes].endereco.bairo);
	printf("Quarteirao: ");
	scanf("%d", &dados[quantDocentes].endereco.quarteirao);
	printf("Numero da casa: ");
	scanf("%d",&dados[quantDocentes].endereco.casanr);
	printf("Insira o seu Departamento: ");
	scanf("%s", &dados[quantDocentes].departamento);
	printf("Digite um numero que deseja que seja a sua senha: ");
	scanf("%d", &dados[quantDocentes].senha);
}


void cadastrarEstudante (struct cadastro dados[], int cont){

	printf("Digite o seu nome: ");
	scanf("%s",&dados[cont].nome);
	printf("=====Data de Nascimento======\n");
	printf("Dia: ");
	scanf("%d",&dados[cont].birthday.dia);
	printf("Mes: ");
	scanf("%d", &dados[cont].birthday.mes);
	printf("Ano: ");
	scanf("%d", &dados[cont].birthday.ano);
	printf("=====Endereco======\n");
	printf("Distrito/Municipio: ");
	scanf("%s", &dados[cont].endereco.distrito);
	printf("Bairo: ");
	scanf("%s",&dados[cont].endereco.bairo);
	printf("Quarteirao: ");
	scanf("%d", &dados[cont].endereco.quarteirao);
	printf("Numero da casa: ");
	scanf("%d",&dados[cont].endereco.casanr);
	printf("Insira o seu Curso: ");
	scanf("%s", dados[cont].curso);
	printf("Digite um numero que deseja que seja a sua senha: ");
	scanf("%d", &dados[cont].senha);

}


void cadastrarFuncionario (struct cadastro dados[], int cont){
	
	printf("Digite o seu nome: ");
	scanf("%s",dados[cont].nome);
	printf("=====Data de Nascimento======\n");
	printf("Dia: ");
	scanf("%d",&dados[cont].birthday.dia);
	printf("Mes: ");
	scanf("%d", &dados[cont].birthday.mes);
	printf("Ano: ");
	scanf("%d", &dados[cont].birthday.ano);
	printf("=====Endereco======\n");
	printf("Distrito/Municipio: ");
	scanf("%s", dados[cont].endereco.distrito);
	printf("Bairo: ");
	scanf("%s",dados[cont].endereco.bairo);
	printf("Quarteirao: ");
	scanf("%d", dados[cont].endereco.quarteirao);
	printf("Numero da casa: ");
	scanf("%d",&dados[cont].endereco.casanr);
	printf("Insira a sua Categoria: ");
	// scanf("%s", &dados[cont].categoria);
	printf("Digite um numero que deseja que seja a sua senha: ");
	scanf("%d", &dados[cont].senha);
}


void visualizarCadastros(struct cadastro dados[], int quantidade){
	int i;
	for (i=0;i<quantidade;i++){
		printf("%s\t", dados[i].nome);
		printf("Nascido em %d/%d/%d \n", dados[i].birthday.dia, dados[i].birthday.mes, dados[i].birthday.ano);
		printf("\tResidente de %s-%s-Q%d-C%d \n", dados[i].endereco.distrito, dados[i].endereco.bairo, dados[i].endereco.quarteirao, dados[i].endereco.casanr);
		printf("\tDepartamento(Docente): %s \n", dados[i].departamento);
		printf("\tCurso(Estudante): %s \n", dados[i].curso);
		printf("\n\n");
		printf("\tSenha: %d", dados[i].senha);

	}
}


void lancarNotas(struct cadastro dados[], int cont, int pos){
	int i, y, cod;
	float soma=0;
	printf("\nInforme o codigo do estudante: ");
	scanf("%d", &cod);

	for(i = 0; i < cont; i++) {
		if(i == cod) {
			for(y = 0; y < 3; y++) {
				printf("\nNota %d: ", (y+1));
				scanf("%f", &dados[cod].disc[pos].notas[y]);
				soma += dados[cod].disc[pos].notas[y];
			}

			dados[cod].disc[pos].media = soma/3;
			break;
		}
		else {
			printf("\n\nAluno nao encontrado!");
		}
	}
}


void visualizarNotas(struct cadastro dados[], int cont) {
	int i, y, cod;
	
	printf("\nInforme o codigo do estudante: ");
	scanf("%d", &cod);

	for(i = 0; i < cont; i++) {
		if(i == cod) {
			for(y = 0; y < 3; y++) {
				printf("\nNota %d: %f", (y+1), &dados[cod].disc[0].notas[y]);
			}

			break;
		}
		else {
			printf("\n\nAluno nao encontrado!");
		}
	}
}


void pautaDocente(struct cadastro dados[], int quantEstudantes, int pos){
	int i;
	
	printf("NOME\t\t NOTA 1\t\t NOTA 2\t\t NOTA 3\t\t MEDIA\t\t RESULTADO\n");
	for(i=0; i<quantEstudantes; i++) {
		printf("%s\t %f\t %f\t %f\t %f\t %s", dados[i].nome, dados[i].disc[pos].notas[0], dados[i].disc[pos].notas[1], dados[i].disc[pos].notas[2], dados[i].disc[pos].media, (dados[i].disc[pos].media > 10)? "Aprovado" : "Reprovado" );
	}
	
}


void pautaEstudante( struct cadastro dados[], int quantDocentes, int nr){
	int i;
	printf("Disciplina\t\t NOTA 1\t\t NOTA 2\t\t NOTA 3\t\t MEDIA\t\t RESULTADO\n");
	for(i=0;i<quantDocentes;i++){
		printf("%s\t %f\t %f\t %f\t %f\t %s", dados[nr].disc[i].nome, dados[nr].disc[i].notas[0], dados[nr].disc[i].notas[1], dados[nr].disc[i].notas[2], dados[nr].disc[i].media, (dados[nr].disc[i].media > 10 ? "Aprovado" : "Reprovado") );
	 }
}


void estatistica(struct cadastro dados[], int quantEstudantes, int nr){
	int max=0, max1=0, max2=0, max3=0, min=0, i;
	for(i=0;i<quantEstudantes;i++){
		if(max<dados[i].disc[nr].notas[0]){
			max=i;
		}
	}
	for(i=0;i<quantEstudantes;i++){
		if(max1<dados[i].disc[nr].notas[1]){
			max1=i;
		}
	}
	for(i=0;i<quantEstudantes;i++){
		if(max2<dados[i].disc[nr].notas[2]){
			max2=i;
		}
	}
	for(i=0;i<quantEstudantes;i++){
		if(max3<(float)(dados[i].disc[nr].notas[0]+dados[i].disc[nr].notas[1]+dados[i].disc[nr].notas[2])/3){
			max3=i;
		}
	}
	for(i=0;i<quantEstudantes;i++){
		if(min>(float)(dados[i].disc[nr].notas[0]+dados[i].disc[nr].notas[1]+dados[i].disc[nr].notas[2])/3){
			min=i;
		}
	}

	printf("Disciplina %s", dados[0].disc[nr].nome);
	printf("\nO estudante com maior nota no teste 1 e : %s", dados[max].nome);
	printf("\nO estudante com maior nota no teste 2 e : %s", dados[max1].nome);
	printf("\nO estudante com maior nota no teste 3 e : %s", dados[max2].nome);
	printf("\nO estudante com maior media e : %s", dados[max3].nome);
	printf("\nO estudante com pior media e : %s", dados[min].nome);
}


void alterarSenha(struct cadastro dados[], int quantidade){
	int i, j, senha, nova, confirm;
	j=0;
	printf("Digite a sua antiga senha: ");
	scanf("%d", &senha);
	for(i=0;i<quantidade;i++){
		if(senha==dados[i].senha){
			j++;
		}
	}
	if(j!=0){
		printf("Digite a nova senha:");
		scanf("%d", &nova);
		printf("Confirme a nova senha: ");
		scanf("%d", &confirm);

		if(confirm==nova){
			dados[i].senha=confirm;
			printf("A sua nova senha e: %d", dados[i].senha);
		}
		else{
			printf("Algum erro na confirmacao da senha!");
		}
	}
	else{
		printf("SENHA INEXISTENTE!");
	}
}


int main (){

	int op1, op2, opf, quant_cad=0, quantDocentes=0, quantEstudantes=0, code;
	int code_adm=123, numero, tentativas;
	char nomeD[20], nomeE[20], nomeF[20], disc[20];
	struct cadastro docente[10];
	struct cadastro est[10];



	do{
		system("cls");
		printf("=============SISTEMA DE GESTAO UNIVERSITARIA==========");
		printf("\n1.Administrador\n2.Docente\n3.Estudante\nEntrar como: ");
		scanf("%d", &op1);
		switch (op1){
			case 1:{
				printf("Insira a sua senha: ");
				scanf("%d",  &code);
				if(code==code_adm){
					system("cls");
					printf("1.Cadastrar Docentes\n2.Cadastrar Estudantes\n4.Visualizar cadastrados\nEscolha uma opcao: ");
					scanf("%d", &op2);
					switch (op2){
						case 1:{
							system("cls");
							cadastrarDocente(docente,quantDocentes);
							quantDocentes++;
						break;}
						case 2:{
							system("cls");
							cadastrarEstudante(est,quantEstudantes);
							quantEstudantes++;
						break;}
						case 4:{
							system("cls");
							printf("\n=================Docentes================\n");
							if(quantDocentes!=0){
								visualizarCadastros(docente,quantDocentes);
							} else {
								printf("Nenhum Docente foi cadastrado ainda.");
							}

							printf("\n================Estudantes===============\n");
							if(quantEstudantes!=0){
								visualizarCadastros(est,quantEstudantes);
							} else {
								printf("Nenhum estudante foi cadastrado ainda.");
							}
						break;}
					}

				}
			break;}
			case 2:{
				system("cls");
				if(quantDocentes==0){
					printf("Nao existe nenum docente em nossa BD. Tente cadasstrar!");
				} else{
					
					printf("Digite o seu nome: ");
					scanf("%s", &nomeD);
					printf("Insira a sua senha: ");
					scanf("%d",  &code);
					int i, j=0, pos;
					for(i=0;i<quantDocentes;i++){
						if((code==docente[i].senha) || (docente[i].nome==nomeD)){
							j++;
							pos=i;
						}
					}
					if(j!=0){
						printf("1.lancar notas\n2.Ver Pauta\n3.Ver estatistica\n4.Alterar senha\nEscolha uma opcao: ");
						scanf("%d", &op2);
						switch (op2){
							case 1:{
								system("cls");
								if(quantEstudantes==0){
									printf("Nao existe estudante cadastrado. Tente cadastrar!");
								} else{
									lancarNotas(est,quantEstudantes,pos);
									
								}
							break;}
							case 2:{
								system("cls");
								if(quantEstudantes==0){
									printf("Nao existe estudante cadastrado. Tente cadastrar!");
								}
								else{
									system("cls");
									pautaDocente(est,quantEstudantes,pos);
									}

							break;}
							case 3:{
								system("cls");
								estatistica(est,quantEstudantes,pos);
							break;}
							case 4:{
								system("cls");
								alterarSenha(docente,quantDocentes);
							break;}
						}
					} else{
						printf("SENHA INCORRECTA");
					}
				}
			
			break;}
			case 3:{
				system("cls");
				if(quantEstudantes==0){
					printf("Nao existe nenum estudante em nossa BD. Tente cadasstrar!");
				} else {
					printf("Digite o seu nome: ");
					scanf("%s", &nomeE);
					printf("Insira a sua senha: ");
					scanf("%d",  &code);
					int i, j=0;
					for(i=0;i<quantEstudantes;i++){
						if((code==est[i].senha) || (est[i].nome==nomeE)){
							j++;
							numero=i;
						}
					}

					if(j!=0){
						printf("1.Ver Resultados\n2.Alterar senha\nEscolha uma opcao:");
						scanf("%d", &op2);
						switch(op2){
							case 1:{
								system("cls");
								pautaEstudante(est,quantDocentes,numero);
							break;}
							case 2:{
								system("cls");
								alterarSenha(docente,quantEstudantes);
							break;}
						}
					}
				}
			 break;}
		}

		printf("\nDigite 1 para continuar o programa ou qualquer outro nr para fechar:");
		scanf("%d",&opf);
	
	}while(opf==1);
	getch();

	return 0;
}