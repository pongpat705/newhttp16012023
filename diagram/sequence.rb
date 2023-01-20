@startuml
title Employee: Management
actor Hr as hr #ffcc88
entity hr_api #fe050e
database employee #d5e9dc

hr -> hr_api : POST /api/employee
activate hr
    activate hr_api
        hr_api -> employee: SQL insert into employee
        employee -> hr_api: success
        hr_api -> hr: response
    deactivate hr_api
deactivate hr
@enduml
