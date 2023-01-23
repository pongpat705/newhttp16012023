@startuml
title Restuarant: Management
actor "customer" #deepskyblue

actor "waitress" as waitress #ffcc88

control "waitress-api" #ffcc88

database "order" #ffcc88


control "kitchen-api" #Salmon

actor "kitchen" as kitchen #Salmon



activate "customer"
customer -> waitress: order a menu
deactivate "customer"

activate "waitress"
waitress -> "waitress-api": POST /api/insert/order
    activate "waitress-api"
    "waitress-api" -> order: insert into order (new status, new order_ref)
    "order" ->  "waitress-api": success
    "waitress" <-  "waitress-api": success
    deactivate "waitress-api"
deactivate "waitress"

activate "kitchen"
    kitchen -> "kitchen-api" : GET /api/order/status/new
    activate "kitchen-api"
    "kitchen-api" -> order: select order status = "new"
    order -> "kitchen-api": response
    "kitchen-api" -> kitchen: response
    deactivate "kitchen-api"

    kitchen -> "kitchen-api" : POST /api/order/status/cooking
    activate "kitchen-api"
    "kitchen-api" -> order: update order status = cooking
    order -> "kitchen-api": success
    "kitchen-api" -> kitchen: response
    deactivate "kitchen-api"

    kitchen -> kitchen: cooking
    kitchen -> "kitchen-api" : POST /api/order/status/cooked
    activate "kitchen-api"
    "kitchen-api" -> order: update order status = cooked
    order -> "kitchen-api": success
    "kitchen-api" -> kitchen: response
    deactivate "kitchen-api"
    
deactivate "kitchen"

activate "waitress"
    waitress -> "waitress-api" : GET /api/order/status/cooked
    activate "waitress-api"
    "waitress-api" -> order: select order status = "cooked"
    order -> "waitress-api": response
    "waitress-api" -> waitress: response
    deactivate "waitress-api"

   
    waitress -> "waitress-api" : POST /api/order/status/serving
    activate "waitress-api"
    "waitress-api" -> order: select order status = "serving"
    order -> "waitress-api": response
    "waitress-api" -> waitress: response
    deactivate "waitress-api"

waitress -> customer: serve a plate

    waitress -> "waitress-api" : POST /api/order/status/served
    activate "waitress-api"
    "waitress-api" -> order: select order status = "served"
    order -> "waitress-api": response
    "waitress-api" -> waitress: response
    deactivate "waitress-api"

deactivate "waitress"


@enduml