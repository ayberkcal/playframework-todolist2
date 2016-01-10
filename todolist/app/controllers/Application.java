package controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.*;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public Form<Task> taskForm = Form.form(Task.class);

	public Result index() {
		return redirect(routes.Application.tasks());

		// return ok(index.render("Your new application is ready."));
	}

	public Result tasks() {
		return ok(views.html.index.render(Task.all(), taskForm));
	}

	public Result newTask() {
		Form<Task> filledForm = taskForm.bindFromRequest();
		if(filledForm.hasErrors())
		{
			return badRequest(views.html.index.render(Task.all(), taskForm));
		}
		else
		{
			Task.create(filledForm.get());
			return redirect(routes.Application.tasks());
		}
	}

	public Result deleteTask(Long id) {
		return TODO;
	}
	

}
