package main

import (
	"crud-golang/config"
	"crud-golang/controllers/categorycontroller"
	"crud-golang/controllers/homecontroller"
	"crud-golang/controllers/productcontroller.go"
	"log"
	"net/http"
)

func main() {
	config.ConnectDB()

	//1. Homepage
	http.HandleFunc("/", homecontroller.Welcome)

	//2. Categories
	http.HandleFunc("/categories", categorycontroller.Index)
	http.HandleFunc("/categories/add", categorycontroller.Add)
	http.HandleFunc("/categories/edit", categorycontroller.Edit)
	http.HandleFunc("/categories/delete", categorycontroller.Delete)

	//3. Products
	http.HandleFunc("/products", productcontroller.Index)
	http.HandleFunc("/products/add", productcontroller.Add)
	http.HandleFunc("/products/detail", productcontroller.Detail)
	http.HandleFunc("/products/edit", productcontroller.Edit)
	http.HandleFunc("/products/delete", productcontroller.Delete)

	log.Println("Server running on port 1234")
	log.Fatal(http.ListenAndServe(":1234", nil))
}
