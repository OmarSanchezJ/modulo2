use admin;
db.createUser(
{
	user: "libreria",
	pwd: "libreria",
	roles: [ { role: "userAdmin", db: "librosdb" }]
});