

%% Part A in Imperial Units

disp("This Is Part A The Input Must Be In Imperial");

D0= input('Enter Diameter d0 In Inches');
Di= input('Enter Diameter di In Inches');
D= input('Enter Diameter d In Inches');
L1= input('Enter Length L1 In Inches');
L2= input('Enter Length L2 In Inches');
L3= input('Enter Length L3 In Inches');
E1= input('Enter The Material Property E1 In Ksi');
E2= input('Enter The Material Property E2 In Ksi');
E3= input('Enter The Material Property E3 Ksi');
Pc=input('Enter The Force Pc In Kips');


f1=(L1*4)/(pi*E1*(D0^2 - Di^2));
f2=(L2*4)/(pi*E2*D^2);
f3=(L3*4)/(pi*E3*D^2);

%% Formulae
%% 1) F1(-1) + F2(1) F3(0)= 0
 %% 2) F1(0) + F2(-1) F3(1)= -Pc
   %% 3) F1(f1) + F2(f2) F3(f3) = 0
 
 
A= [-1 1 0; 0 -1 1; f1 f2 f3];
b= [0; -Pc; 0]; 
f= (A)^-1 * b;


stress1= 4*f(1,1)/(pi*(D0^2-Di^2));
stress2=4*f(2,1)/(pi*D^2);
stress3= 4*f(3,1)/(pi*D^2);


ub= f1*f(1,1);
uc=f2*f(2,1) + ub;


fprintf("The Stress In Rod 1 Is %dksi(T) Rod 2 Is %dksi(T) Rod 3 Is %dksi(C)\n",stress1,stress2,-1*stress3)
 
fprintf("The Change In Displacement In ub=%din, and uc=%din\n",ub,uc);



%%Part B  %%Metric  

%% "m" beside all the variable stands for METRIC
 fprintf("\n This Is Part B All Inputs Must Be In Metric\n");


 D0m= input('Enter Diameter d0 In mm')*(10^-3);
Dim= input('Enter Diameter di In mm')*(10^-3);
Dm= input('Enter Diameter d In mm')*(10^-3);

L1m= input('Enter Length L1 In m');
L2m= input('Enter Length L2 In m');
L3m= input('Enter Length L3 In m');

E1m= input('Enter The Material Property E1 In Gpa')*(10^9);
E2m= input('Enter The Material Property E2 In Gpa')*(10^9);
E3m= input('Enter The Material Property E3 In Gpa')*(10^9);

Pcm=input('Enter The Force Pc In Kn')*(10^3);

f1m=(L1m*4)/(pi*E1m*(D0m^2 - Dim^2));
f2m=(L2m*4)/(pi*E2m*Dm^2);
f3m=(L3m*4)/(pi*E3m*Dm^2);

%% 1) F1(-1) + F2(1) F3(0)= 0
 %% 2) F1(0) + F2(-1) F3(1)= -Pc
   %% 3) F1(f1) + F2(f2) F3(f3) = 0
 
Am= [-1 1 0; 0 -1 1; f1m f2m f3m];
bm= [0; -Pcm; 0]; 
fm= (Am)^-1 * bm;

stress1m= 4*fm(1,1)/(pi*(D0m^2 - Dim^2));
stress2m=4*fm(2,1)/(pi*Dm^2);
stress3m= (-1)*4*fm(3,1)/(pi*Dm^2);

ubm= f1m*fm(1,1);
ucm=f2m*fm(2,1) + ubm;

fprintf("The Stress In Rod 1 Is %dMpa(T) Rod 2 Is %dMpa(T) Rod 3 Is %dMpa(C)\n",stress1m*10^-6,stress2m*10^-6,stress3m*10^-6);

fprintf("\nThe Change In Displacement In ub=%dm, and uc=%dm\n",ubm,ucm);
 
 
