# Rails Database Manager

This mini rails layer is solely responsible for the postgres database and its versioning.

##Dependencies

rails, ruby, postgres.

## Getting started

* First make sure postgres server is running. enter psql on command line to check that.

* Setup the db name and credentials to your liking:
config/database.yml does that:

    - check username/password will work on your db. `select * from pg_roles;`

        if not: `createuser postgres`, and `ALTER USER postgres WITH SUPERUSER`

    - database: this names the db to what you want seed_db is a placeholder from my use.

    - If you changed the username/pass/database then also change application.conf in the scala resource file to reflect that

* install relevant gems with: `bundle install`
* Create the Database with: `rake db:setup`
* Load the schema with: `rake db:schema:load`

Now you are done. Confirm working by connecting `psql <dbname>` and checking the users table exists.

##Making a change to the db

`rails g migration <migration name>`

##Updating the db

`rake db:migrate`
