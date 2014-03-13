fUnit
=====

fame/timeiq unit testing


some useful fame code


fame -d . -s simplerules.setup.inp

--decimals 6

--type  outcome_u[THISDAY(Q)+LateInQ+i], simplerules'outcome_u[THISDAY(Q)+LateInQ+i-1],simplerules'outcome_u[THISDAY(Q)+LateInQ+i-2],simplerules'pce[THISDAY(Q)+LateInQ+i],simplerules'ygap[THISDAY(Q)+LateInQ+i],simplerules'ygap[THISDAY(Q)+LateInQ+i-1]


 decimals 6

type  last_outcome_u[THISDAY(Q)+LateInQ+i], simplerules'last_outcome_u[THISDAY(Q)+LateInQ+i-1],simplerules'last_outcome_u[THISDAY(Q)+LateInQ+i-2],simplerules'last_pce[THISDAY(Q)+LateInQ+i],simplerules'last_ygap[THISDAY(Q)+LateInQ+i],simplerules'last_ygap[THISDAY(Q)+LateInQ+i-1]

