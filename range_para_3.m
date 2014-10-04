Import["sum_prod.m"];
For[i = 410, i <= 460, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr3.txt"];
];
