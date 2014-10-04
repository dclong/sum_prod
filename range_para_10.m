Import["sum_prod.m"];
For[i = 603, i <= 610, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr10.txt"];
];
