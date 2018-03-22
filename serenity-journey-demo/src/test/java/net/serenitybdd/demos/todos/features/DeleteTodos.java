package net.serenitybdd.demos.todos.features;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/maintain_my_todo_list/delete_a_todo.feature")
public class DeleteTodos {}
