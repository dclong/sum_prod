TwoAddends[s_Integer, range_List] := Module[
    {lower, upper},
    lower = range[[1]];
    upper = range[[2]];
    Table[{i, s - i}, {i, Max[lower, s - upper], Min[upper, s - lower, s/2]}]
];

TwoFactors[p_Integer, range_List] := Module[
    {lower, upper, div, n},
    lower = range[[1]];
    upper = range[[2]];
    div = Select[Divisors[p], # >= Max[lower, p/upper] && # <= Min[upper, p/lower, Sqrt[p]] &];
    Map[{#, p/#} &, div]
];

S1[pair_List, range_List] := Module[
    (*can be simplified a lot for the case of [ 2, n]*)
    (*sum must be odd and sum - 2 cannot be a prime*)
    {s, candidates},
    s = Total[pair];
    candidates = TwoAddends[s, range];
    Length[candidates] > 1 && 
    Apply[And, Length[TwoFactors[Times @@ #, range]] > 1 & /@ candidates]
];

P1[pair_List, range_List] := Module[
    {p, candidates},
    p = Times @@ pair;
    candidates = TwoFactors[p, range];
    Length[candidates] > 1 && 
    Total[Boole[S1[#, range] & /@ candidates]] == 1
];

S2[pair_List, range_List] := Module[
    {s, candidates},
    s = Total[pair];
    candidates = TwoAddends[s, range];
    Length[candidates] > 1 && 
    Total[Boole[P1[#, range] & /@ candidates]] == 1
];

SumProductPuzzle[range_List] := Module[
    {lower, upper, candidates},
    lower = range[[1]];
    upper = range[[2]];
    candidates = Flatten[Table[{i, j}, {i, lower, upper}, {j, i, upper}], 1];
    Select[candidates, S1[#, range] && P1[#, range] && S2[#, range] &]
];

SolutionNumber[range_List] := Length[SumProductPuzzle[range]];

