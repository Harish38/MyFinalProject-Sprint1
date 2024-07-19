SELECT c.issue_id, cs.systemtime
FROM cinstrument c
JOIN tagencytrade t ON c.issue_id = t.issue_id
JOIN tagntrosettlement ts ON t.refno = ts.refno
JOIN clearingsystem cs ON ts.CLRno = cs.CLRno;