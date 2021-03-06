import subprocess

from flask import Flask, request

app = Flask("railIl2020_app")


@app.route("/rail")
def rail():
    return subprocess.check_output(["java", "-classpath",
                                    "bin", "user.UsersMain",
                                    request.args.get('outformat'), request.args.get('source'),
                                    request.args.get('destination'), request.args.get('hour'),
                                    request.args.get('minutes')])


if __name__ == "__main__":
    subprocess.run("javac -d bin src/railIl/*.java", shell=True)
    subprocess.run("javac -d bin -cp bin src/user/*.java", shell=True)
    app.run(port=8000, host="0.0.0.0")
