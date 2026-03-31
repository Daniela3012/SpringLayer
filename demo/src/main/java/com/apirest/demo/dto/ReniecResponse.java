package com.apirest.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class ReniecResponse {
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "second_last_name")
    private String secondLastName;
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonProperty(value = "document_number")
    private String documentNumber;
}
