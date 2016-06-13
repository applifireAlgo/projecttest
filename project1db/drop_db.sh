




echo $PATH
DB_PATH=/tmp/applifire/db/LDVWCCIANASOJBFXKQTYAQ
MYSQL=/usr/bin
USER=project1
PASSWORD=project1
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'