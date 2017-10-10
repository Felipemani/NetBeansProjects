#include <iostream>
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()

{
    float tol;
    double int1,int2,funcao1,funcao2,mediap,funcaodamedia,mediap2,funcaodamedia2,erro;
    double raiz;
    int i;
    tol=0,01;
    printf("Digite o primeiro termo do intervalo aceito pela funcao\n");
       scanf("%lf", &int1);   
       printf("Digite o primeiro termo do intervalo aceito pela funcao\n");
       scanf("%lf", &int2);      
  funcao1=sqrt(int1)-5*exp(-int1);
   funcao2=sqrt(int2)-5*exp(-int2);
      printf("funcao 1 eh %lf\n", funcao1);
       printf("funcao 1 eh %lf\n", funcao2);
       mediap=((int1*funcao2)-(int2*funcao1))/(funcao2-funcao1);
 funcaodamedia=sqrt(mediap)-5*exp(-mediap);
 printf("funcao de Xi eh %lf\n", funcaodamedia);
 if (funcaodamedia>0)
 {
  int1=int1;
  int2=mediap;
}
else
{
          int1=mediap;
          int2=int2;
    }
   
        funcao1=sqrt(int1)-5*exp(-int1);
   funcao2=sqrt(int2)-5*exp(-int2);
    mediap2=((int1*funcao2)-(int2*funcao1))/(funcao2-funcao1);
    funcaodamedia2=sqrt(mediap2)-5*exp(-mediap2);
      erro=fabs(mediap2-mediap);
                   printf("erro %lf\n", erro);
                 
                 
                 
                 while(erro>tol)    {
                        
                         if (funcaodamedia2>0)
                         
                {
 
  int1=int1;
  int2=mediap;
                }
                        else 

                {
          int1=mediap2;
          int2=int2;
                }
                funcaodamedia=funcaodamedia2;
                     funcao1=sqrt(int1)-5*exp(-int1);
          funcao2=sqrt(int2)-5*exp(-int2);
          mediap2=((int1*funcao2)-(int2*funcao1))/(funcao2-funcao1);
          funcaodamedia2=sqrt(mediap2)-5*exp(-mediap2);
          erro=fabs(mediap2-mediap);
                                    }
printf("o resultado eh %lf\n", mediap2);
                         
    system ("pause");
    
return 0;
}
