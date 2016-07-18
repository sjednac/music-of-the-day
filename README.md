# music-of-the-day

A simple web service in **Clojure**.

## Spotify integration

1. Setup a Spotify application [here](https://developer.spotify.com/my-applications/).
2. You should define `SPOTIFY_CLIENT_ID` and `SPOTIFY_CLIENT_SECRET` in your environment or adjust profile [settings](https://github.com/weavejester/environ) for the project.

## Docker Deployment

Prepare the Docker image using the [uberimage](lein-uberimage) plugin:

    lein uberimage

Run the container:

    docker run --rm --name=motd \
      -p 8080:8080 \
      -e SPOTIFY_CLIENT_ID=$SPOTIFY_CLIENT_ID \
      -e SPOTIFY_CLIENT_SECRET=$SPOTIFY_CLIENT_SECRET \
      sbilinski/music-of-the-day
