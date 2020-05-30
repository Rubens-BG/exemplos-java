﻿update historico_status_contribuinte set status = 'DESATIVADO' where id in (
select hisstacon.id from contribuinte con
inner join contribuinte_historico_status_contribuinte conhisstacon
on conhisstacon.id_contribuinte = con.id
inner join historico_status_contribuinte hisstacon
on conhisstacon.id_historico_status_contribuinte = hisstacon.id
where hisstacon.data_final_vigencia is null and con.id not in (
963,
913,
952,
176,
90,
946,
159,
947,
967,
688,
937,
721,
912,
867,
905,
910,
505,
890,
16,
785,
219,
136,
17,
206,
250,
185,
779,
843,
11,
868,
353,
973,
12,
448,
706,
344,
824,
897,
777,
800,
830,
477,
385,
251,
20,
902,
483,
132,
6,
862,
906,
259,
914,
740,
974,
909,
933,
680,
495,
24,
787,
163,
925,
977,
25,
958,
26,
730,
930,
27,
907,
955,
806,
962,
825,
851,
814,
901,
5,
945,
960,
956,
916,
745,
603,
32,
876,
789,
663,
629,
985,
669,
940,
767,
698,
966,
980,
37,
493,
194,
38,
117,
753,
621,
95,
954,
633,
898,
845,
43,
395,
815,
734,
964,
971,
47,
908,
48,
450,
340,
983,
631,
774,
50,
268,
792,
638,
953,
939,
849,
104,
530,
786,
864,
972,
976,
831,
760,
743,
469,
443,
838,
941,
58,
247,
932,
519,
804,
178,
979,
459,
829,
408,
936,
950,
61,
922,
539,
820,
232,
750,
874,
714,
594,
776,
816,
926,
904,
411,
393,
410,
718,
84,
639,
920,
799,
243,
476,
173,
865,
310,
755,
863,
526,
99,
125,
713,
200,
970,
817,
371,
869,
724,
681,
875,
842,
969,
975,
951,
261,
981,
848,
675,
850,
921,
75,
978,
76,
986,
826,
128,
846,
982,
648,
762,
715,
204,
943,
984,
935,
837,
911,
957,
899,
918,
836,
961,
227,
605,
705,
883,
640,
419,
968,
924,
82,
361,
189,
888,
938,
180,
562,
611,
839,
445,
720,
647,
757,
919,
540,
965,
942,
563,
949,
683,
803,
832,
931,
809,
959,
763,
841,
380,
928,
759)
);