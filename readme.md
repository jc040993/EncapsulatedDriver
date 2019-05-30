# Encapsulated Driver

In my organization, in production server db admin's usually change password frequently. So with this driver my aim was to remove dependency of changing the password in all those properties file(which they had to do everytime db password is changed in many projects/applications) and changing/updating in single properties file with application independent encryption.

Here in this project I have made for mssql server but you can easily modify it for other db servers or generalize it for all db servers.

The implementation for `sqlserver.EncapsulatedMSSQLDriver.getPassword()` is removed because it varies from organization policies. So you can write it for yourself :)